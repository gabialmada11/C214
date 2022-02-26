package br.inatel.service;

import br.inatel.model.Game;
import br.inatel.model.Platform;
import br.inatel.model.Publisher;
import br.inatel.utils.CsvUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TesteGameService {

    private static List<Game> gameList;

    @BeforeClass
    public static void initClass() throws URISyntaxException {
        Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
        gameList = CsvUtils.readGameCsv(caminho);
    }

    @Test
    public void testeGamesPS4(){
        List<Game> ps4Games = GameService.getListByPlatform(gameList, Platform.PS4);

        Assert.assertEquals(5,ps4Games.size());
    }

    @Test
    public void testeGameX360(){
        List<Game> x360Games = GameService.getListByPlatform(gameList, Platform.X360);

        Assert.assertEquals(16,x360Games.size());
    }

    @Test
    public void testeGameActivision(){
        List<Game> activisionGames = GameService.getByPuBlisher(gameList, Publisher.Activision);

        Assert.assertEquals(14,activisionGames.size());
    }

    @Test
    public void testeGameMicrosoft(){
        List<Game> microsoftGames = GameService.getByPuBlisher(gameList, Publisher.MicrosoftGameStudios);

        Assert.assertEquals(6,microsoftGames.size());
    }
}
