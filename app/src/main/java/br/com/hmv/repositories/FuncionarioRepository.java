package br.com.hmv.repositories;

import br.com.hmv.models.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findFuncionarioByIdFuncionario(String idFuncionario);

    void deleteByIdFuncionario(String idFuncionario);
}
