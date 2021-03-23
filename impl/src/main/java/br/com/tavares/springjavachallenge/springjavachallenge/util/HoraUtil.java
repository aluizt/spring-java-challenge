package br.com.tavares.springjavachallenge.springjavachallenge.util;

import br.com.tavares.springjavachallenge.springjavachallenge.model.HorasApontadasModel;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HoraUtil {

    public HoraUtil() {
    }

    public String acumularHoras(List<HorasApontadasModel> horasApontadasModels) {
        List<String> lista = horasApontadasModels.stream()
                .map(HorasApontadasModel::getHoras)
                .map(LocalTime::toString)
                .collect(Collectors.toList());
        Duration total = Duration.ZERO;
        for (String tempo : lista) {
            String[] partes = tempo.split(":");
            total = total.plusHours(Long.parseLong(partes[0])).plusMinutes(Long.parseLong(partes[1]));
        }
        return String.format("%02d:%02d", (total.toDaysPart() * 24) + total.toHoursPart(), total.toMinutesPart());
    }
}
