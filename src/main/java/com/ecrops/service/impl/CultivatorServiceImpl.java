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

	public List<Cultivator> getCultivatorsByKathaNo(Cultivator cultivator) {
		return repo.getCultivatorDetailsByKathaNo(cultivator.getKhNo(), cultivator.getCr_vcode());
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
		cultivatorDto.setCultivatorType(cultivator.getCultivatorType());
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

	public Double getAnubhavadarExtent(Cultivator cultivator) {
		Double anubhavadarExtent = repo.getAnubhavadarExtent(cultivator.getPart_key(), cultivator.getKhNo(),
				cultivator.getCr_vcode());
		anubhavadarExtent = anubhavadarExtent == null ? 0.0 : anubhavadarExtent;
		return anubhavadarExtent;
	}
	
	public Double getTotalOccupantExtent(Cultivator cultivator) {
		Double totalOccupantExtent = repo.getTotalOccupantExtent(cultivator.getPart_key(), cultivator.getKhNo(),
				cultivator.getCr_vcode());
		totalOccupantExtent = totalOccupantExtent == null ? 0.0 : totalOccupantExtent;
		return totalOccupantExtent;
	}

}
