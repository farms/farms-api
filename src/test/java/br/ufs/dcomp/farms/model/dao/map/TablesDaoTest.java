package br.ufs.dcomp.farms.model.dao.map;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.ufs.dcomp.farms.model.dao.SpringUtil;
import br.ufs.dcomp.farms.model.entity.dba.TableDba;
import junit.framework.TestCase;

public class TablesDaoTest extends TestCase {
	
	@Autowired
	private TablesDao tablesDao;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		tablesDao = (TablesDao) SpringUtil.getInstance().getBean(TablesDao.class);
	}
	
	@Test
	public void testShouldGetAllTablesByNmSchema() {
		List<TableDba> tableList = tablesDao.getByNmSchema("public");
		assertNotNull(tableList);
		assertFalse(tableList.isEmpty());
		assertEquals(41, tableList.size());
		for (TableDba tables : tableList) {
			System.out.println(tables.getNmTable());
		}
	}
}
