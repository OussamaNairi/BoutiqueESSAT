package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ICategorieDao extends JpaRepository<ICategorieDao, Integer>{

}