package com.ecrops.service.impl;

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
	public int updateCultivatorOwnerDetails(Cultivator cultivator) {

		Optional<CultivatorDto> optionalDto = cultivatorCompositeRepository
				.findById(new CultivatorEmbedableDto(cultivator.getBookingId(), cultivator.getPart_key()));
		CultivatorDto cultivatorDto = optionalDto.get();
		cultivatorDto.setAadharNo(cultivator.getAadharNo());
		cultivatorDto.setOccupantExtent(cultivator.getOccupantExtent());
		CultivatorDto cDtoResult = cultivatorCompositeRepository.save(cultivatorDto);

		return cDtoResult != null ? 1 : 0;
	}

	public Cultivator saveCultivatorsData(Cultivator cultivator) {

		return repo.save(cultivator);
	}

	@Override
	public int updateCultivatorDetails(Cultivator cultivator) {

		Optional<CultivatorDto> optionalDto = cultivatorCompositeRepository
				.findById(new CultivatorEmbedableDto(cultivator.getBookingId(), cultivator.getPart_key()));
		CultivatorDto cultivatorDto = optionalDto.get();
		cultivatorDto.setOccupantExtent(cultivator.getOccupantExtent());
		cultivatorDto.setCultivatorType(cultivator.getCultivatorType());
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
