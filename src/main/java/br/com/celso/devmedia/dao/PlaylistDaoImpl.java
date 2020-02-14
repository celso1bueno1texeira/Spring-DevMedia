package br.com.celso.devmedia.dao;

import br.com.celso.devmedia.domain.Playlist;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PlaylistDaoImpl implements PlaylistDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Playlist playlist) {
        em.persist(playlist);

    }

    @Override
    public List<Playlist> recuperar(){
        return em.createQuery(qlString: "select p from Playlist p", Playlist.class).getResultList();
    }

    @Override
    public Playlist recuperarPorID(long id) {
        return em.find(Playlist.class, id);
    }

    @Override
    public void atualizar(Playlist playlist) {
        em.merge(playlist);
    }

    @Override
    public void excluir(long id) {
        em.remove(em.getReference(Playlist.class, id));
    }
}
