package com.example.config;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.entity.AcessoriosModel;
import com.example.entity.AluguelModel;
import com.example.entity.CarroModel;
import com.example.entity.FabricanteModel;
import com.example.entity.ModeloCarroModel;
import com.example.enums.Categoria;
import com.example.repository.AcessorioRepository;
import com.example.repository.AluguelRepository;
import com.example.repository.ApoliceSeguroRepository;
import com.example.repository.CarroRepository;
import com.example.repository.FabricanteRepository;
import com.example.repository.FuncionarioRepository;
import com.example.repository.ModeloCarroRepository;
import com.example.repository.MotoristaRepository;

@Configuration
@Profile("test")
public class DatabaseConfig {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private MotoristaRepository motoristaRepository;
	
    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Autowired
    private AcessorioRepository acessorioRepository;

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;
    
    @Bean
    public CommandLineRunner loadData() {
    	return (args) -> {
    		
    	};
    }
    
    private List<AcessoriosModel> cargaIncialAcessorios() {
    	
    }
    
    private List<ModeloCarroModel> cargaInicialModeloCarro(List<FabricanteModel> fabricante) {
    	
    }
    
    private List<FabricanteModel> cargaInicialFabricante() {
    	
    }
    
    
    
    
    
    
    @Override
    public void run(String... args) throws Exception {

        FabricanteModel toyota = new FabricanteModel();
        toyota.setNome("Toyota");

        FabricanteModel honda = new FabricanteModel();
        honda.setNome("Honda");


        fabricanteRepository.saveAll(Arrays.asList(toyota, honda));

        ModeloCarroModel corolla = new ModeloCarroModel();
        corolla.setDescricao("Corolla");
        corolla.setCategoria(Categoria.SEDAN_COMPACTO);
        corolla.setFabricante(toyota);

        ModeloCarroModel civic = new ModeloCarroModel();
        civic.setDescricao("Civic");
        civic.setCategoria(Categoria.SEDAN_COMPACTO);
        civic.setFabricante(honda);


        modeloCarroRepository.saveAll(Arrays.asList(corolla, civic));

        AcessoriosModel arCondicionado = new AcessoriosModel();
        arCondicionado.setAcessorios("Ar-condicionado");

        AcessoriosModel direcaoHidraulica = new AcessoriosModel();
        direcaoHidraulica.setAcessorios("Direção hidráulica");

        acessorioRepository.saveAll(Arrays.asList(arCondicionado, direcaoHidraulica));

        CarroModel carro1 = new CarroModel();
        carro1.setPlaca("ABC-1234");
        carro1.setCor("Azul");
        carro1.setChassi("XYZ987654321");
        carro1.setValorDiaria(new BigDecimal("150.00"));
        carro1.setAcessorios(Arrays.asList(arCondicionado, direcaoHidraulica));
        carro1.setModelo(corolla);

        CarroModel carro2 = new CarroModel();
        carro2.setPlaca("DEF-5678");
        carro2.setCor("Preto");
        carro2.setChassi("XYZ987654322");
        carro2.setValorDiaria(new BigDecimal("180.00"));
        carro2.setAcessorios(Arrays.asList(arCondicionado));
        carro2.setModelo(civic);

        List<CarroModel> carros = Arrays.asList(carro1, carro2);
        carroRepository.saveAll(carros);

        AluguelModel aluguel1 = new AluguelModel();
        Calendar dataPedido = Calendar.getInstance();
        dataPedido.set(2024, Calendar.AUGUST, 30);
        aluguel1.setDataPedido(dataPedido);
        aluguel1.setDataEntrega(new Date());
        aluguel1.setDataDevolucao(new Date());
        aluguel1.setCarro(carro1);
        aluguel1.setMotorista(null);
        aluguel1.setValorTotal(new BigDecimal("150.00"));
        aluguel1.setApolice(null);

        aluguelRepository.saveAll(Arrays.asList(aluguel1));
    }
}