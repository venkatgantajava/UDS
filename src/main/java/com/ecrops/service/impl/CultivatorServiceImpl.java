package com.ecrops.service.impl;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecrops.dto.CultivatorDto;
import com.ecrops.dto.CultivatorEmbedableDto;
import com.ecrops.entity.Cultivator;
import com.ecrops.repo.CultivatorCompositeRepository;
import com.ecrops.repo.CultivatorRepository;
import com.ecrops.service.CultivatorService;

@Service
public class CultivatorServiceImpl implements CultivatorService {

	@Autowired
	private CultivatorRepository repo;

	@Autowired
	CultivatorCompositeRepository cultivatorCompositeRepository;

	public List<Cultivator> listAll() {

		return repo.findAll();
	}

	public Cultivator get(Integer id) {
		return repo.getById(id);
	}

	public List<Cultivator> getCultivatorsByKathaNo(Integer kathaNo) {
		return repo.getCultivatorDetailsByKathaNo(kathaNo);
	}

	@Override
	public int updateOwnerOrEnjoerDetails(Cultivator cultivator) {

		Optional<CultivatorDto> optionalDto = cultivatorCompositeRepository
				.findById(new CultivatorEmbedableDto(cultivator.getBookingId(), cultivator.getPart_key()));
		CultivatorDto cultivatorDto = optionalDto.get();
		if (cultivator.getCultivatorType() != null && cultivator.getCultivatorType().equalsIgnoreCase("L")) {
			cultivatorDto.setAadharNo(cultivator.getAadharNo());
		}

		cultivatorDto.setOccupantExtent(cultivator.getOccupantExtent());
		cultivatorDto.setUpdatedby(cultivator.getUpdatedby());
		cultivatorDto.setUpdateon(Timestamp.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant()));
		CultivatorDto cDtoResult = cultivatorCompositeRepository.saveAndFlush(cultivatorDto);

		return cDtoResult != null ? 1 : 0;
	}

	public Cultivator saveCultivatorsData(Cultivator cultivator) {
		cultivator.setEntry_date(Timestamp.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant()));
		return repo.save(cultivator);
	}

	@Override
	public int updateCultivatorDetails(Cultivator cultivator) {

		Optional<CultivatorDto> optionalDto = cultivatorCompositeRepository
				.findById(new CultivatorEmbedableDto(cultivator.getBookingId(), cultivator.getPart_key()));
		CultivatorDto cultivatorDto = optionalDto.get();
		cultivatorDto.setOcName(cultivator.getOcName());
		cultivatorDto.setFatherName(cultivator.getFatherName());
		cultivatorDto.setOccupantExtent(cultivator.getOccupantExtent());
		cultivatorDto.setAadharNo(cultivator.getAadharNo());
		cultivatorDto.setCultivatorType(cultivator.getCultivatorType());
		cultivatorDto.setUpdatedby(cultivator.getUpdatedby());
		cultivatorDto.setUpdateon(Timestamp.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant()));
		CultivatorDto cDtoResult = cultivatorCompositeRepository.save(cultivatorDto);

		return cDtoResult != null ? 1 : 0;
	}

	@Override
	public void deleteCultivatorDetails(Cultivator cultivator) {

		Optional<CultivatorDto> optionalDto = cultivatorCompositeRepository
				.findById(new CultivatorEmbedableDto(cultivator.getBookingId(), cultivator.getPart_key()));
		cultivatorCompositeRepository.delete(optionalDto.get());

	}

}
