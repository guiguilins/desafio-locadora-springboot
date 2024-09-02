package com.example.config;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.domain.entity.AcessorioModel;
import com.example.domain.entity.AluguelModel;
import com.example.domain.entity.ApoliceSeguroModel;
import com.example.domain.entity.CarroModel;
import com.example.domain.entity.FabricanteModel;
import com.example.domain.entity.FuncionarioModel;
import com.example.domain.entity.ModeloCarroModel;
import com.example.domain.entity.MotoristaModel;
import com.example.domain.enums.Categoria;
import com.example.domain.enums.Sexo;
import com.example.domain.repository.AcessorioRepository;
import com.example.domain.repository.AluguelRepository;
import com.example.domain.repository.ApoliceSeguroRepository;
import com.example.domain.repository.CarroRepository;
import com.example.domain.repository.FabricanteRepository;
import com.example.domain.repository.FuncionarioRepository;
import com.example.domain.repository.ModeloCarroRepository;
import com.example.domain.repository.MotoristaRepository;

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
    private AcessorioRepository acessorioRepository;
    @Autowired
    private ModeloCarroRepository modeloCarroRepository;
    @Autowired
    private FabricanteRepository fabricanteRepository;
    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;
    @Autowired
    private AluguelRepository aluguelRepository;
    
    @Bean
    public CommandLineRunner loadData() {
        return (args) -> {

            List<FabricanteModel> fabricanteEntities = cargaFabricante();
            List<ModeloCarroModel> modeloCarroEntities = cargaModeloCarro(fabricanteEntities);

            AcessorioModel arCondicionado = new AcessorioModel();
            arCondicionado.setAcessorios("Ar-condicionado");
            arCondicionado = acessorioRepository.save(arCondicionado); 

            AcessorioModel direcaoHidraulica = new AcessorioModel();
            direcaoHidraulica.setAcessorios("Direção hidráulica");
            direcaoHidraulica = acessorioRepository.save(direcaoHidraulica); 

            CarroModel carro = new CarroModel();
            carro.setPlaca("ABC1234");
            carro.setCor("Azul");
            carro.setChassi("534764");
            carro.setValorDiaria(new BigDecimal(123.0));
            carro.setModelo(modeloCarroEntities.get(0));
            carro.setAcessorios(Arrays.asList(arCondicionado, direcaoHidraulica));
            carroRepository.save(carro); 

            FuncionarioModel funcionario = new FuncionarioModel();
            funcionario.setMatricula("16099");
            funcionario.setCpf("11111111111");
            funcionario.setSexo(Sexo.MASCULINO);
            funcionario.setDataNascimento(new Timestamp(System.currentTimeMillis()));
            funcionario.setNome("Sono");
            funcionarioRepository.save(funcionario);

            MotoristaModel motorista = new MotoristaModel();
            motorista.setNumeroCNH("1111111111");
            motorista.setCpf("22222222222");
            motorista.setSexo(Sexo.MASCULINO);
            motorista.setDataNascimento(new Timestamp(System.currentTimeMillis()));
            motorista.setNome("Batata");
            motoristaRepository.save(motorista);

            CarroModel carro2 = new CarroModel();
            carro2.setPlaca("DEF5678");
            carro2.setCor("Vermelho");
            carro2.setChassi("5345432");
            carro2.setValorDiaria(new BigDecimal(100.0));
            carro2.setModelo(modeloCarroEntities.get(1));
            carro2.setAcessorios(Arrays.asList(arCondicionado, direcaoHidraulica));
            carroRepository.save(carro2);

            ApoliceSeguroModel apolice = new ApoliceSeguroModel(new BigDecimal(120), false, false, false);
            apoliceSeguroRepository.save(apolice);

            AluguelModel aluguel = new AluguelModel();
            aluguel.setCarro(carro);
            aluguel.setDataDevolucao(new Date());
            aluguel.setDataEntrega(new Date());
            aluguel.setApolice(apolice);
            aluguel.setValorTotal(new BigDecimal(125));
            aluguel.setMotorista(motorista);
            Calendar c = Calendar.getInstance();
            aluguel.setDataPedido(c);
            aluguelRepository.save(aluguel);

            apolice.setAluguel(aluguel);
        };
    }

    private List<ModeloCarroModel> cargaModeloCarro(List<FabricanteModel> fabricante) {
        return Arrays.asList("Picape", "Utilitario").stream().map(modeloCarro -> {
            ModeloCarroModel modeloCarroModel = new ModeloCarroModel();
            modeloCarroModel.setDescricao(modeloCarro);
            if(modeloCarroModel.getDescricao().equals("Picape")) {
                modeloCarroModel.setCategoria(Categoria.ESPORTIVO);
                modeloCarroModel.setFabricante(fabricante.get(1));
            } else {
                modeloCarroModel.setCategoria(Categoria.MINIVAN);
                modeloCarroModel.setFabricante(fabricante.get(0));
            }
            return modeloCarroRepository.save(modeloCarroModel);
        }).collect(Collectors.toList());
    }

    private List<FabricanteModel> cargaFabricante() {
        return Arrays.asList("Honda", "Volkswagen").stream().map(fabricante -> {
            FabricanteModel fabricanteEntity = new FabricanteModel();
            fabricanteEntity.setNome(fabricante);
            return fabricanteRepository.save(fabricanteEntity);
        }).collect(Collectors.toList());
    }
}
