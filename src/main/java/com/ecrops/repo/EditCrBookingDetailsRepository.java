package com.ecrops.repo;

import com.ecrops.model.EditCrBookingDtlsEntity;
import com.ecrops.model.EditCropBookingDetailsModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EditCrBookingDetailsRepository {

    private final JdbcTemplate jdbcTemplate;

    public EditCrBookingDetailsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<EditCrBookingDtlsEntity> geEditCrBookingDetails(EditCropBookingDetailsModel ecbd) {

        String query = "select occupname,occupfname,oc_name,oc_fname,cr_sno,kh_no,cr_vcode,bookingid,cr_crop, cr_no,cr_sow_date,variety,cr_farmeruid " +
                " from ecrop2023.cr_details_r042023 where cr_vcode="+ecbd.getvCode()+" and cr_year="+ecbd.getCropYear()+" and cr_season='"+ecbd.getSeason()+"' " +
                "and owner_tenant='O' " + getSearchValue(ecbd)+ "and vaaauth ='Y' and vroauth='Y' and ekyc is null and bookingid not in " +
                " (select bookingid from ecrop2023.cr_details_org_details where correctiontype='"+ecbd.getCorrectionType()+"' and  cr_vcode=417003) ";

        List<EditCrBookingDtlsEntity> ecbdList = jdbcTemplate.query(query, new EditCrBookingDetailsRowMapper<EditCrBookingDtlsEntity>());

        return ecbdList;
    }

    public String getSearchValue(EditCropBookingDetailsModel ecbd){
        String searchValue = "";
        if("1".equalsIgnoreCase(ecbd.getSearchType())){
            searchValue = "and cr_sno='"+ecbd.getSurveyNo()+"' ";
        } else if("2".equalsIgnoreCase(ecbd.getSearchType())){
            searchValue = "and kh_no = "+ecbd.getKathaNo();
        } else if("3".equalsIgnoreCase(ecbd.getSearchType())){
            searchValue = "and cr_farmeruid='"+ecbd.getAadharNo()+"' ";
        }
        return searchValue;
    }
    public static class EditCrBookingDetailsRowMapper<E> implements RowMapper<EditCrBookingDtlsEntity> {

        public EditCrBookingDtlsEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            EditCrBookingDtlsEntity ecbd = new EditCrBookingDtlsEntity();
            ecbd.setOccupname(rs.getString("occupname"));
            ecbd.setOccupfname(rs.getString("occupfname"));
            ecbd.setCr_sno(rs.getString("cr_sno"));
            ecbd.setKh_no(rs.getInt("kh_no"));
            ecbd.setCr_vcode(rs.getInt("cr_vcode"));
            ecbd.setBookingid(rs.getInt("bookingid"));
            ecbd.setCr_crop(rs.getInt("cr_crop"));
            ecbd.setCr_no(rs.getString("cr_no"));
            ecbd.setCr_sow_date(rs.getString("cr_sow_date"));
            ecbd.setVariety(rs.getString("variety"));
            ecbd.setCr_farmeruid(rs.getString("cr_farmeruid"));
            ecbd.setOc_name(rs.getString("oc_name"));
            ecbd.setOc_fname(rs.getString("oc_fname"));
            return ecbd;
        }
    }
}
