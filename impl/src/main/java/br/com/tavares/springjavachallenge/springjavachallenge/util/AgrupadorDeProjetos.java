package br.com.tavares.springjavachallenge.springjavachallenge.util;

import br.com.tavares.springjavachallenge.springjavachallenge.model.HorasApontadasModel;
import br.com.tavares.springjavachallenge.springjavachallenge.model.ProjetoModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Component
public class AgrupadorDeProjetos {

    private HoraUtil horaUtil;

    public AgrupadorDeProjetos(HoraUtil horaUtil) {
        this.horaUtil = horaUtil;
    }

    public List<ProjetoModel> agrupaProjetos(List<HorasApontadasModel> lista) {
        var map = agruparPorProjeto(lista);
        List<ProjetoModel> projetos = new ArrayList<>();
        for (Integer projeto : map.keySet()) {
            List<HorasApontadasModel> horasApontadasModels = map.get(projeto);
            projetos.add(ProjetoModel.builder()
                    .projeto(projeto)
                    .horasApontadas(agrupaHorasApontadas(horasApontadasModels))
                    .build());
        }
        return projetos;
    }

    private Map<Integer, List<HorasApontadasModel>> agruparPorProjeto(List<HorasApontadasModel> lista) {
        return lista.stream().collect(groupingBy(HorasApontadasModel::getIdProjeto));
    }

    private Map<Integer, List<HorasApontadasModel>> agruparPorMatricula(List<HorasApontadasModel> horasApontadas) {
        return horasApontadas.stream().collect(groupingBy(HorasApontadasModel::getMatriculaUsuario));
    }

    private List<HorasApontadasModel> agrupaHorasApontadas(List<HorasApontadasModel> horasApontadas) {
        var agrupadoPorMatricula = agruparPorMatricula(horasApontadas);
        List<HorasApontadasModel> horasAgrupadas = new ArrayList<>();
        for (Integer matricula : agrupadoPorMatricula.keySet()) {
            List<HorasApontadasModel> restorno = agrupadoPorMatricula.get(matricula);
            horasAgrupadas.add(HorasApontadasModel.builder()
                    .matriculaUsuario(restorno.get(0).getMatriculaUsuario())
                    .idProjeto(restorno.get(0).getIdProjeto())
                    .totalDeHoras(horaUtil.acumularHoras(restorno))
                    .build());
        }
        return horasAgrupadas;
    }
}
