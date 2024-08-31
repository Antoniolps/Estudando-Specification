package br.com.lepao.Estudos.Repository.Spec;

import br.com.lepao.Estudos.Models.Enum.GeneroEnum;
import br.com.lepao.Estudos.Models.Filtros.PessoaFiltro;
import br.com.lepao.Estudos.Models.Pessoa;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PessoaSpec {

    public static Specification<Pessoa> filtros(PessoaFiltro filtro){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(Objects.nonNull(filtro.getNome())) {
                if (!(filtro.getNome().equals(""))) {
                    predicates.add(criteriaBuilder.like(
                            root.get("nome"), filtro.getNome()
                    ));
                }
            }

            if(Objects.nonNull(filtro.getIdade())) {
                if(!(filtro.getIdade() <= 0)){
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                            root.get("idade"), filtro.getIdade()
                    ));
                }
            }

            if(Objects.nonNull(filtro.getGenero())) {
                if (!(filtro.getGenero().equals(""))) {
                    predicates.add(criteriaBuilder.equal(
                            root.get("genero"), GeneroEnum.valueOf(filtro.getGenero())
                    ));
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
