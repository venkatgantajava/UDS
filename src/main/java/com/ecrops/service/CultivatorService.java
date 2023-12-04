package com.ecrops.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecrops.entity.Cultivator;

@Service
public interface CultivatorService {

	public List<Cultivator> listAll();

	public Cultivator get(Integer id);

	public List<Cultivator> getCultivatorsByKathaNo(Integer kathaNo);

	public int updateCultivatorOwnerDetails(Cultivator cultivator);

	public Cultivator saveCultivatorsData(Cultivator cultivator);

	public int updateCultivatorDetails(Cultivator cultivator);

	public void deleteCultivatorDetails(Cultivator cultivator);

}
