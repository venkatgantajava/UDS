package com.ecrops.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecrops.entity.Cultivator;
import com.ecrops.repo.CultivatorRepository;
import com.ecrops.service.CultivatorService;

@Service
public class CultivatorServiceImpl implements CultivatorService {

	@Autowired
	private CultivatorRepository repo;

	public List<Cultivator> listAll() {

		return repo.findAll();
	}

	public Cultivator get(Integer id) {
		return repo.getById(id);
	}

	public List<Cultivator> getCultivatorsByKathaNo(Integer kathaNo) {
		return repo.getCultivatorDetailsByKathaNo(kathaNo);
	}

	public Cultivator save(Cultivator cultivator) {

		return repo.save(cultivator);
	}

	@Override
	public void delete(int bookingId) {
		// TODO Auto-generated method stub

	}

}
