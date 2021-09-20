package com.cadastro.cadastro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepos extends JpaRepository<Clientes, Long> {

	Clientes findClientesBycpf(int cpf);

	Clientes findClientesByemail(String email);
}
