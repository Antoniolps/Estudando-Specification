package br.com.lepao.Estudos.Services;

import br.com.lepao.Estudos.Models.Filtros.PessoaFiltro;
import br.com.lepao.Estudos.Models.Pessoa;
import br.com.lepao.Estudos.Repository.PessoaRepository;
import br.com.lepao.Estudos.Repository.Spec.PessoaSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class PessoaService{

    @Autowired
    private PessoaRepository pessoaRepository;

    public Page<Pessoa> findFiltred(Pageable pageable, PessoaFiltro filtro){
        return pessoaRepository.findAll(PessoaSpec.filtros(filtro), pageable);
    }
}
