package com.ecrops.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ecrops.entity.Cr_Booking_PartitionEntity;

import java.util.List;

@Service
public class DynamicTableService {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public DynamicTableService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Cr_Booking_PartitionEntity> getEntitiesFromDynamicTable(String dynamicTableName) {
		String sql = "SELECT * FROM " + dynamicTableName;
		return jdbcTemplate.query(sql, (resultSet, i) -> {
			Cr_Booking_PartitionEntity entity = new Cr_Booking_PartitionEntity();
			entity.setCr_sno(resultSet.getString("cr_sno"));
			return entity;
		});
	}

	public void insertIntoDynamicTable(String dynamicTableName, String crSno, String part_key, int cr_dist_code,
			int cr_mand_code, int cr_vcode, int cr_year, String cr_season, String cr_farmeruid, int kh_no,
			String oc_name, String oc_fname, String occupname, String occupfname, int tot_extent) {
		String owner_tenant = "o";

		String sql = "INSERT INTO " + dynamicTableName
				+ " (cr_sno,part_key,cr_dist_code,cr_mand_code,cr_vcode,cr_year,cr_season,cr_farmeruid,kh_no,owner_tenant,oc_name,oc_fname,occupname,occupfname,tot_extent) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		jdbcTemplate.update(sql, crSno, part_key, cr_dist_code, cr_mand_code, cr_vcode, cr_year, cr_season,
				cr_farmeruid, kh_no, owner_tenant, oc_name, oc_fname, occupname, occupfname, tot_extent);

	}
}
