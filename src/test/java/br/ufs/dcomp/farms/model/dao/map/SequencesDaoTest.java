package br.ufs.dcomp.farms.model.dao.map;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.ufs.dcomp.farms.model.dao.SpringUtil;
import br.ufs.dcomp.farms.model.entity.dba.SequenceDba;
import junit.framework.TestCase;

public class SequencesDaoTest extends TestCase {
	
	@Autowired
	private SequencesDao sequencesDao;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		sequencesDao = (SequencesDao) SpringUtil.getInstance().getBean(SequencesDao.class);
	}
	
	@Test
	public void testShouldGetAllSequencesByNmSchema() {
		List<SequenceDba> sequencesList = sequencesDao.getByNmSchema("public");
		assertNotNull(sequencesList);
		assertFalse(sequencesList.isEmpty());
		for (SequenceDba sequences : sequencesList) {
			System.out.println(sequences.getNmSequence());
		}
	}
}