package br.com.hmv.services;

import br.com.hmv.dtos.general.EspecialidadeDTO;
import br.com.hmv.dtos.general.TelefoneDTO;
import br.com.hmv.dtos.request.FuncionarioInsertRequestDTO;
import br.com.hmv.dtos.responses.FuncionarioDefaultResponseDTO;
import br.com.hmv.models.entities.Especialidade;
import br.com.hmv.models.entities.Funcionario;
import br.com.hmv.models.entities.Telefone;
import br.com.hmv.models.enums.StatusFuncionarioEnum;
import br.com.hmv.models.mappers.FuncionarioMapper;
import br.com.hmv.repositories.EspecialidadeRepository;
import br.com.hmv.repositories.FuncionarioRepository;
import br.com.hmv.repositories.TelefoneRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FuncionarioService {
    private static Logger logger = LoggerFactory.getLogger(FuncionarioService.class);
    private FuncionarioRepository funcionarioRepository;
    private EspecialidadeRepository especialidadeRepository;
    private TelefoneRepository telefoneRepository;

    @Transactional
    public FuncionarioDefaultResponseDTO criacao(FuncionarioInsertRequestDTO dto) {
        String logCode = "criacao(FuncionarioInsertRequestDTO)";
        logger.info("{} - solicitacao de inclusao {}", logCode, dto);

        var entity = dtoToEntityOnCreate(dto);
        entity = funcionarioRepository.save(entity);

        var listEspecialidades = entity.getEspecialidades();
        var listTelefones = entity.getTelefones();

        logger.info("{} - Convenio incluido com sucesso {}", logCode, entity);
        return new FuncionarioDefaultResponseDTO(entity, listEspecialidades, listTelefones);
    }

//    @Transactional
//    public HospitalDefaultResponseDTO updateStatus(String codigoUnidade, HospitalAtualizaStatusUnidadeRequestDTO dto) {
//        String logCode = "updateStatus(String, HospitalAtualizaStatusUnidadeRequestDTO)";
//        logger.info("{} - solicitacao de atualizacao de status {}", logCode, dto);
//
//        try {
//            var objOptional = hospitalRepository.findHospitalsByCodigoUnidade(codigoUnidade);
//            Hospital entity = objOptional.orElseThrow(() -> new ResourceNotFoundException("recurso nao encontrado id: " + codigoUnidade));
//
//            //passa status novo
//            entity.setCodigoStatusUnidade(dto.getStatusUnidadeHospitalEnum().getCodigoStatusHospitalUnidade());
//            entity = hospitalRepository.save(entity);
//
//            logger.info("{} - atualizacao realizada com sucesso {}", logCode, entity);
//            return new HospitalDefaultResponseDTO(entity);
//        } catch (EntityNotFoundException e) {
//            logger.warn("{} - recurso nao encontrado id: {} ", codigoUnidade);
//            throw new ResourceNotFoundException("Recurso nao encontrado id: " + codigoUnidade);
//        }
//    }


//    @Transactional
//    public HospitalDefaultResponseDTO addEspecialidade(String codigoUnidade, HospitalAddEspecialidadeRequestDTO dto) {
//        String logCode = "addEspecialidade(String, HospitalAddEspecialidadeRequestDTO)";
//        logger.info("{} - solicitacao de atualizacao de status {}", logCode, dto);
//
//        try {
//            var objOptional = hospitalRepository.findHospitalsByCodigoUnidade(codigoUnidade);
//            Hospital entity = objOptional.orElseThrow(() -> new ResourceNotFoundException("recurso nao encontrado id: " + codigoUnidade));
//
//            var entityEspecialidade = especialidadeRepository.getOne(dto.getIdEspecialidade());
//
//            //passa status novo
//            entity.getEspecialidades().add(entityEspecialidade);
//            entity = hospitalRepository.save(entity);
//
//            logger.info("{} - atualizacao realizada com sucesso {}", logCode, entity);
//            return new HospitalDefaultResponseDTO(entity, entity.getEspecialidades());
//        } catch (EntityNotFoundException e) {
//            logger.warn("{} - recurso nao encontrado id: {} ", logCode, codigoUnidade);
//            throw new ResourceNotFoundException("Recurso nao encontrado id: " + codigoUnidade);
//
//        } catch (Exception e) {
//            logger.warn("{} - erro ao adicionar especialidade: {} ", logCode, e);
//            throw new ResourceNotFoundException("Recurso nao encontrado id: " + codigoUnidade);
//        }
//    }

//    @Transactional
//    public HospitalDefaultResponseDTO removeEspecialidade(String codigoUnidade, HospitalRemoveEspecialidadeRequestDTO dto) {
//        String logCode = "removeEspecialidade(String, HospitalRemoveEspecialidadeRequestDTO)";
//        logger.info("{} - solicitacao de atualizacao de status {}", logCode, dto);
//
//        try {
//            var objOptional = hospitalRepository.findHospitalsByCodigoUnidade(codigoUnidade);
//            Hospital entity = objOptional.orElseThrow(() -> new ResourceNotFoundException("recurso nao encontrado id: " + codigoUnidade));
//
//            var entityEspecialidade = especialidadeRepository.getOne(dto.getIdEspecialidade());
//
//            //passa status novo
//            entity.getEspecialidades().remove(entityEspecialidade);
//            entity = hospitalRepository.save(entity);
//
//            logger.info("{} - atualizacao realizada com sucesso {}", logCode, entity);
//            return new HospitalDefaultResponseDTO(entity, entity.getEspecialidades());
//        } catch (EntityNotFoundException e) {
//            logger.warn("{} - recurso nao encontrado id: {} ", logCode, codigoUnidade);
//            throw new ResourceNotFoundException("Recurso nao encontrado id: " + codigoUnidade);
//
//        } catch (Exception e) {
//            logger.warn("{} - erro ao adicionar especialidade: {} ", logCode, e);
//            throw new ResourceNotFoundException("Recurso nao encontrado id: " + codigoUnidade);
//        }
//    }

//    @Transactional
//    public void delete(String codigoUnidade) {
//        String logCode = "delete(String)";
//        logger.info("{} - deletando recurso: {}", logCode, codigoUnidade);
//
//        try {
//            hospitalRepository.deleteByCodigoUnidade(codigoUnidade);
//            logger.info("{} - recurso deletado com sucesso: {}", logCode, codigoUnidade);
//
//        } catch (EmptyResultDataAccessException e) {
//            logger.warn("{} - recurso nao encontrado: {}", logCode, codigoUnidade);
//            throw new ResourceNotFoundException("Recurso nao encontrado id: " + codigoUnidade);
//
//        } catch (DataIntegrityViolationException e) {
//            logger.warn("{} - erro de integridade de dados: {}", logCode, codigoUnidade);
//            throw new DatabaseException("Integrity violation - Ao deletar convenio id: " + codigoUnidade);
//        }
//    }

//    @Transactional(readOnly = true)
//    public Page<HospitalDefaultResponseDTO> findAllPaged(Pageable pageable) {
//        String logCode = "findAllPaged(Pageable)";
//        logger.info("{} - consulta paginada de recursos vide parametros {}", logCode, pageable);
//
//        Page<Hospital> list = hospitalRepository.findAll(pageable);
//        logger.info("{} - consulta paginada de recursos realizada com sucesso: {}", logCode, list);
//        return list.map(itemHospitalEntity -> new HospitalDefaultResponseDTO(itemHospitalEntity));
//    }
//
//    @Transactional(readOnly = true)
//    public HospitalDefaultResponseDTO findByIdCodigoUnidade(String codigoUnidade) {
//        String logCode = "findById(String)";
//        logger.info("{} - buscando recurso pelo id: {}", logCode, codigoUnidade);
//
//        Optional<Hospital> obj = hospitalRepository.findHospitalsByCodigoUnidade(codigoUnidade);
//        Hospital entity = obj.orElseThrow(() -> new ResourceNotFoundException("recurso nao encontrado id: " + codigoUnidade));
//
//        logger.info("{} - recurso encontrado: {}", logCode, entity);
//        var especialidades = entity.getEspecialidades();
//        return new HospitalDefaultResponseDTO(entity, especialidades);
//    }


    private Funcionario dtoToEntityOnCreate(FuncionarioInsertRequestDTO dto) {
        String logCode = "dtoToEntityOnCreate(FuncionarioDTO)";
        logger.info("{} - convertendo dto de cricao para entity {}", logCode, dto);

        var entity = FuncionarioMapper.INSTANCE.deDtoParaFuncionario(dto);

        entity.setIdFuncionario(UUID.randomUUID().toString());
        entity.setCodigoGrupoFuncao(dto.getGrupoFuncaoFuncionario().getCodigoGrupoFuncaoFuncionario());
        entity.setCodigoStatusFuncionario(StatusFuncionarioEnum.ATIVO.getCodigoStatusFuncionario());

        entity.getEspecialidades().clear();
        for (EspecialidadeDTO dtoItem : dto.getEspecialidades()) {
            Especialidade especialidade = especialidadeRepository.getOne(dtoItem.getId()); //instanciando uma categoria sem tocar no banco de dados, mas gera aos moldes do banco
            entity.getEspecialidades().add(especialidade);
        }

        entity.getTelefones().clear();
        for (TelefoneDTO dtoItem : dto.getTelefones()) {
            Telefone telefone = telefoneRepository.getOne(dtoItem.getId()); //instanciando uma categoria sem tocar no banco de dados, mas gera aos moldes do banco
            entity.getTelefones().add(telefone);
        }

        logger.info("{} - conversao realizada com sucesso {}", logCode, entity);
        return entity;
    }
}
