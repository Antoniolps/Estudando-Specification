package br.com.lepao.Estudos.Controllers;

import br.com.lepao.Estudos.Models.Filtros.PessoaFiltro;
import br.com.lepao.Estudos.Models.Pessoa;
import br.com.lepao.Estudos.Services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin(origins = "*")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/all-filtred/{page}/{size}")
    public Page<Pessoa> allPagedFiltred(@PathVariable int page,
                                        @PathVariable int size,
                                        PessoaFiltro filtro){
        Pageable pageable = PageRequest.of(page, size);

        Page<Pessoa> pessoas = pessoaService.findFiltred(pageable, filtro);
        return pessoas;
    }
}
