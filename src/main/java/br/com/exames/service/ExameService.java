package br.com.exames.service;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.exames.dto.ExameDto;
import br.com.exames.dto.ResponseObject;
import br.com.exames.entity.Exame;
import br.com.exames.repository.ExameDao;

@Service
public class ExameService {

	@Autowired
	private ExameDao exameDao;

	@Autowired
	private ModelMapper modelMapper;

	
	public Optional<ResponseObject>  salvarExame(ExameDto exame, MultipartFile file,Path fileStorageLocation) {

		ResponseObject resposta = new ResponseObject();
		Exame exameMap = modelMapper.map(exame, Exame.class);

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] buffer = new byte[8192];
		int read = 0;

		digest.update(buffer, 0, read);

		byte[] md5sum = digest.digest();
		BigInteger bigInt = new BigInteger(1, md5sum);
		String output = bigInt.toString(16);

		System.out.println("MD5: " + output);

		try {
			fileName = output + "-" + StringUtils.cleanPath(file.getOriginalFilename());
			Path targetLocation = fileStorageLocation.resolve(fileName);
			file.transferTo(targetLocation);

			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/files/download/")
					.path(fileName).toUriString();

			exameMap.setIdentificadorExame(fileName);
			exameMap = exameDao.save(exameMap);
			resposta.setEntityId(200L);
			resposta.setMessage("Registro salvo com sucesso!");
			resposta.setObj(exameMap);

		} catch (IOException ex) {
			ex.printStackTrace();
			resposta.setEntityId(422L);
			resposta.setMessage("Erro no processo !");
			resposta.setObj(exameMap);
		}

		return Optional.ofNullable(resposta);

	}

}
