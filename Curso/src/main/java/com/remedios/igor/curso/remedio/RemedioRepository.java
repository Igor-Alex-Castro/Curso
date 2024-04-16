package com.remedios.igor.curso.remedio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RemedioRepository extends JpaRepository<Remedio, Long>{

	@Query("SELECT REM FROM remedio REM WHERE REM.ativo = :pAtivo")
	public List<Remedio> lisyRmediosAtivos(@Param("pAtivo") String ativo) ;
	
	

}
