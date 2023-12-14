package diamond.consoles.modules.desenvolvedor.dto;

import java.time.LocalDate;

import diamond.consoles.modules.desenvolvedor.entity.Desenvolvedor;

public record RespostaCriarDesenvolvedorDTO(
        Long codigo,
        String nome,
        LocalDate dataFundacao,
        String website,
        String sede) {
    public RespostaCriarDesenvolvedorDTO(Desenvolvedor desenvolvedor) {
        this(desenvolvedor.getCodigo(), desenvolvedor.getNome(), desenvolvedor.getDataFundacao(),
                desenvolvedor.getWebsite(), desenvolvedor.getSede());
    }
}
