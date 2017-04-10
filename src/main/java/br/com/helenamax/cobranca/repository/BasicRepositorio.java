package br.com.helenamax.cobranca.repository;

import br.com.helenamax.cobranca.controller.UsuarioSessaoCtr;
import br.com.helenamax.cobranca.util.Validador;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class BasicRepositorio<T, K> implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Class<T> clazz;
    
    @Inject
    protected UsuarioSessaoCtr usuarioSessaoCtr;

    public BasicRepositorio(Class<T> clazz) {
        this.clazz = clazz;
    }

    protected abstract EntityManager getEntityManager();

    public void salvar(T entity) {
        getEntityManager().persist(entity);
    }

    public void alterar(T entity) {
        getEntityManager().merge(entity);
    }

    public void remover(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public void removerEntidadePorId(K id) {
        getEntityManager().remove(getEntityManager().find(clazz, id));
    }

    public T pesquisarPorId(K id) {
        return getEntityManager().find(clazz, id);
    }

    @SuppressWarnings("JPQLValidation")
    public List<T> listar() {
        return getEntityManager().createQuery("select t from " + getClazz().getSimpleName() + " t").getResultList();
    }

    private TypedQuery<T> createQuery(String query, Object... values) {
        TypedQuery<T> qr = getEntityManager().createQuery(query, clazz);
        for (int i = 0; i < values.length; i++) {
            qr.setParameter((i + 1), values[i]);
        }
        return qr;
    }

    private TypedQuery<T> createQueryMine(String query, Object... values) {
        TypedQuery<T> qr = getEntityManager().createQuery(query, clazz);
        for (int i = 0; i < values.length; i++) {
            if (values[i] == null) {
                continue;
            }
            qr.setParameter((i + 1), values[i]);
        }
        return qr;
    }

    protected T getSimpleEntity(String query, Object... values) {
        TypedQuery<T> qr = createQuery(query, values);
        List<T> list = qr.getResultList();
        if (Validador.isCollectionValida(list)) {
            return list.get(0);
        }
        return null;
    }

    protected List<T> getListEntity(String query, Object... values) {
        TypedQuery<T> qr = createQueryMine(query, values);

        return qr.getResultList();
    }

    public CriteriaBuilder getCriteriaBuilder() {
        return getEntityManager().getCriteriaBuilder();
    }

    public List<T> pesquisarPorLike(String propriedade, String valor) {
        CriteriaQuery<T> criteriaQuery = getCriteriaBuilder().createQuery(clazz);
        Root<T> r = criteriaQuery.from(clazz);
        criteriaQuery.select(r);
        criteriaQuery.where(getCriteriaBuilder().like(r.<String>get(propriedade), "%" + valor + "%"));
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public Number countEntity() {
        Number num = getEntityManager().createQuery("select COUNT(t) from " + getClazz().getSimpleName() + " t ", Number.class).getSingleResult();
        return num;

    }

}
