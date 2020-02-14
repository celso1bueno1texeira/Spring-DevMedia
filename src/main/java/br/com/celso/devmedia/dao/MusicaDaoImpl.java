package br.com.celso.devmedia.dao;

import br.com.celso.devmedia.domain.Musica;
import br.com.celso.devmedia.domain.Playlist;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MusicaDaoImpl implements MusicaDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Musica musica) {
        em.persist(musica);
    }

    @Override
    public List<Musica> recuperarPorPlaylist(long playlistId) {
        return em.createQuery(qlString: "select m from Musica m where m.playlist.id = :playlistId", Musica.class)
                .setParameter(name: "playlistId", playlistId)
                .gerResultList();
    }

    @Override
    public Musica recuperarPorPlaylistIdEMusicaId(long playlistId, long musicaId) {
        return em.createQuery( qlString: "select m from Musica m where m.playlist.id = :playlistId and m.Id", Musica.class)
            .setParameter(name: "playlistId", playlistId)
            .setParameter(name: "musicaId", musicaId)
            .getSingleResult();
    }

    @Override
    public void atualizar(Musica musica) {
        em.merge(musica);
    }

    @Override
    public void excluir(long musicaId) {
        em.remove(em.getReference(Musica.class, id));
    }
}
