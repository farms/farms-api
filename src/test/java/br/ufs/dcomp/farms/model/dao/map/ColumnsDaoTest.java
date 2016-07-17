package br.ufs.dcomp.farms.model.dao.map;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.ufs.dcomp.farms.model.dao.SpringUtil;
import br.ufs.dcomp.farms.model.entity.dba.ColumnDba;
import junit.framework.TestCase;

public class ColumnsDaoTest extends TestCase {
	
	@Autowired
	private ColumnsDao columnsDao;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		columnsDao = (ColumnsDao) SpringUtil.getInstance().getBean(ColumnsDao.class);
	}
	
	@Test
	public void testShouldGetAllColumnsByNmSchema() {
		List<ColumnDba> columnList = columnsDao.getByNmTable("adapted_query");
		assertNotNull(columnList);
		assertFalse(columnList.isEmpty());
		for (ColumnDba columnss : columnList) {
			System.out.println(columnss.getNmColumn());
		}
	}
}
