package com.ecrops.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ecrops.entity.ReportEntity;

@Repository
@Transactional
public class ReportRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ReportEntity> getReportData(Integer vscode) {
    	
        String sql = "SELECT transactionid, wbedname, wbemname, vsname, 'XXXXXXXX' || substring(uid,9) as UID, farmername, fathername, "
                   + "cropnameeng, extent, quantity_req, quantity_elg, dosage, authneticatedby, "
                   + "'XXXXXXXX' || substring(authenticateduid,9) as  authenticateduid, authenticatedtransid "
                   + "FROM uds.input_distribution_det_v where regunitcode=?";
        	
        List<Object[]> results = entityManager.createNativeQuery(sql).setParameter(1, vscode).getResultList();
        List<ReportEntity> reportList = new ArrayList<>();

        for (Object[] row : results) {
            ReportEntity report = mapToReportEntity(row);
            reportList.add(report);
        }

        return reportList;
    }

    private ReportEntity mapToReportEntity(Object[] row) {
        ReportEntity report = new ReportEntity();
        report.setTransactionid(row[0] != null ? row[0].toString() : null);
        report.setWbedname(row[1] != null ? row[1].toString() : null);
        report.setWbemname(row[2] != null ? row[2].toString() : null);
        report.setVsname(row[3] != null ? row[3].toString() : null);
        report.setUid(row[4] != null ? row[4].toString() : null);
        report.setFarmername(row[5] != null ? row[5].toString() : null);
        report.setFathername(row[6] != null ? row[6].toString() : null);
        report.setCropnameeng(row[7] != null ? row[7].toString() : null);
        report.setExtent(row[8] != null ? row[8].toString() : null);
        report.setQuantity_req(row[9] != null ? row[9].toString() : null);
        report.setQuantity_elg(row[10] != null ? row[10].toString() : null);
        report.setDosage(row[11] != null ? row[11].toString() : null);
        report.setAuthneticatedby(row[12] != null ? row[12].toString() : null);
        report.setAuthenticateduid(row[13] != null ? row[13].toString() : null);
        report.setAuthenticatedtransid(row[14] != null ? row[14].toString() : null);
        return report;
    }
}
