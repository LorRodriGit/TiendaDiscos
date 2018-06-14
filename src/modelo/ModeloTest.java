package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ModeloTest {
	Modelo instancia;
	@Test
	void test() {
		instancia=new Modelo();
		instancia.selectArticulos();
	}

}
