package br.com.celso.devmedia.dao;

import br.com.celso.devmedia.domain.Playlist;

import java.util.List;

public interface PlaylistDao {

    void salvar(Playlist playlist);
    List<Playlist> recuperar;
    Playlist recuperarPorID(long id);
    void atualizar(Playlist playlist);
    void excluir(long id);
}
