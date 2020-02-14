package br.com.celso.devmedia.dao;

import br.com.celso.devmedia.domain.Musica;
import br.com.celso.devmedia.domain.Playlist;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import java.util.List;


public interface MusicaDao {

    void salvar(Musica musica);
    List<Musica> recuperarPorPlaylist(long playlistId);
    Musica recuperarPorPlaylistIdEMusicaId(long playlistId, long musicaId);
    void atualizar(Musica musica);
    void excluir(long musicaId);

}
