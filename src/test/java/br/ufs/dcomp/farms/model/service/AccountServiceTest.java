package br.ufs.dcomp.farms.model.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.ufs.dcomp.farms.core.FarmsCrypt;
import br.ufs.dcomp.farms.core.FarmsException;
import br.ufs.dcomp.farms.model.dto.ResearcherLoggedDto;
import br.ufs.dcomp.farms.model.dto.ResearcherLoginDto;
import br.ufs.dcomp.farms.model.dto.ResearcherRegisterDto;
import br.ufs.dcomp.farms.model.entity.Researcher;
import br.ufs.dcomp.farms.model.enums.StateEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-application-context.xml")
public class AccountServiceTest {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ResearcherService researcherService;
	
	@Test
	@Transactional
    @Rollback(true)
	public void testShouldLoginResearcherByEmail() throws FarmsException {
		ResearcherRegisterDto researcherRegisterDto = new ResearcherRegisterDto("Maria José Santos", "mariajsantos", "mariajsantos@gmail.com", "12345678", "12345678", StateEnum.A);
		accountService.register(researcherRegisterDto);
		ResearcherLoginDto researcherLoginDto = new ResearcherLoginDto("mariajsantos@gmail.com", "12345678");
		
		ResearcherLoggedDto researcherLoggedDto = accountService.login(researcherLoginDto);
		
		Assert.assertNotNull(researcherLoggedDto);
		Assert.assertEquals(researcherLoginDto.getDsEmail(), researcherLoggedDto.getDsEmail());
	}
	
	@Test
	@Transactional
    @Rollback(true)
	public void testShouldRegisterResearcher() throws FarmsException {
		String nmResearcher = "Maria José Santos";
		String dsSSO = "mariajsantos";
		String dsEmail = "mariajsantos@gmail.com";
		String dsPassword = "12345678";
		String dsConfirmPassword = "12345678";
		StateEnum tpState = StateEnum.A;
		ResearcherRegisterDto researcherRegisterDto = new ResearcherRegisterDto(nmResearcher, dsSSO, dsEmail, dsPassword, dsConfirmPassword, tpState);
		
		accountService.register(researcherRegisterDto);
		
		Researcher researcherResult = researcherService.getByEmail(researcherRegisterDto.getDsEmail());
		
		Assert.assertNotNull(researcherResult);
		Assert.assertEquals(nmResearcher, researcherResult.getNmResearcher());
		Assert.assertEquals(dsSSO, researcherResult.getDsSSO());
		Assert.assertEquals(dsEmail, researcherResult.getDsEmail());
		Assert.assertTrue(FarmsCrypt.checkPassword(dsPassword, researcherResult.getDsPassword()));
		Assert.assertEquals(tpState, researcherResult.getTpState());
	}

	@Test
	@Transactional
    @Rollback(true)
	public void testShouldThrowExceptionAttemptRegisteringResearcherWithEmailAlreadyUse() {
		ResearcherRegisterDto researcherRegisterDto1 = new ResearcherRegisterDto("Maria José Santos", "mariajsantos", "mariajsantos@gmail.com", "12345678", "12345678", StateEnum.A);
		ResearcherRegisterDto researcherRegisterDto2 = new ResearcherRegisterDto("Maria João Santos", "mariajoaos", "mariajsantos@gmail.com", "12345678", "12345678", StateEnum.A);
		
		FarmsException fexExpected = null;
		Integer code = new Integer(2001);
		String description = "Email already in use.";
		
		try {
			accountService.register(researcherRegisterDto1);
			accountService.register(researcherRegisterDto2);
		} catch (FarmsException fex) {
			fexExpected = fex;
			Assert.assertEquals(code, fex.getErrorMessage().getCode());
			Assert.assertEquals(description, fex.getErrorMessage().getDescription());
		} catch (Exception ex) {
			Assert.fail("Incorrect exception.");
		}
		
		Assert.assertNotNull("Expected exception was not released.", fexExpected);
	}
	
	@Test
	@Transactional
    @Rollback(true)
	public void testShouldThrowExceptionAttemptRegisteringResearcherWithUsernameAlreadyUse() {
		ResearcherRegisterDto researcherRegisterDto1 = new ResearcherRegisterDto("Maria José Santos", "mariajsantos", "mariajsantos@gmail.com", "12345678", "12345678", StateEnum.A);
		ResearcherRegisterDto researcherRegisterDto2 = new ResearcherRegisterDto("Maria João Santos", "mariajsantos", "mariajoaosantos@gmail.com", "12345678", "12345678", StateEnum.A);
		
		FarmsException fexExpected = null;
		Integer code = new Integer(2004);
		String description = "Username already in use.";
		
		try {
			accountService.register(researcherRegisterDto1);
			accountService.register(researcherRegisterDto2);
		} catch (FarmsException fex) {
			fexExpected = fex;
			Assert.assertEquals(code, fex.getErrorMessage().getCode());
			Assert.assertEquals(description, fex.getErrorMessage().getDescription());
		} catch (Exception ex) {
			Assert.fail("Incorrect exception.");
		}
		
		Assert.assertNotNull("Expected exception was not released.", fexExpected);
	}
}
