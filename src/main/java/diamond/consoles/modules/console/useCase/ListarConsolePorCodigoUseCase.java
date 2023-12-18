package diamond.consoles.modules.console.useCase;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import diamond.consoles.exceptions.ConsoleNotFoundException;
import diamond.consoles.modules.console.dto.RespostaConsoleCompletoDTO;
import diamond.consoles.modules.console.repository.ConsoleRepositorio;
import diamond.consoles.modules.jogo.dto.RetornoJogoParcialDTO;

@Service
public class ListarConsolePorCodigoUseCase {
    @Autowired
    private ConsoleRepositorio consoleRepositorio;

    @Transactional
    public RespostaConsoleCompletoDTO execute(Long codigo) {
        var console = this.consoleRepositorio.findByCodigo(codigo).orElseThrow(
                () -> {
                    throw new ConsoleNotFoundException();
                });

        var jogos = console.getJogos().stream().map(jogo -> new RetornoJogoParcialDTO(jogo))
                .collect(Collectors.toList());

        return new RespostaConsoleCompletoDTO(console, jogos);
    }
}
