package br.edu.logatti.projetoP2;

import br.edu.logatti.projetoP2.model.Curso;
import br.edu.logatti.projetoP2.service.CursoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProjetoP2Application.class)
@WebAppConfiguration
public class ProjetoP2ApplicationTests {

	@Autowired
	private CursoService cursoService;

	@Test
	public void save() throws Exception {

		long qtd = 5000;

		cursoService.deleteAll();

		for ( int i = 1 ; i <= qtd ; i++){
			cursoService.sendRabbit(new Curso("teste curso"+i));
		}

		Thread.sleep(5000);
		List<Curso> lst = cursoService.findAll();

		System.out.println("Qtd:" + lst.size());
		Assert.assertEquals(lst.size(), qtd);
	}

}
