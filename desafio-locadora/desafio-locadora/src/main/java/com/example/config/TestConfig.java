package com.example.config;

import com.example.domain.entity.*;
import com.example.domain.enums.Categoria;
import com.example.domain.repository.AcessorioRepository;
import com.example.domain.repository.CarroRepository;
import com.example.domain.repository.FabricanteRepository;
import com.example.domain.repository.ModeloCarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    CarroRepository carroRepository;

    @Autowired
    ModeloCarroRepository modeloCarroRepository;

    @Autowired
    FabricanteRepository fabricanteRepository;

    @Autowired
    AcessorioRepository acessorioRepository;

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
    }
}