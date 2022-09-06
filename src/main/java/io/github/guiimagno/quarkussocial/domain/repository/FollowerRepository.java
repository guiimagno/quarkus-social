package io.github.guiimagno.quarkussocial.domain.repository;

import io.github.guiimagno.quarkussocial.domain.model.Follower;
import io.github.guiimagno.quarkussocial.domain.model.User;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;
import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class FollowerRepository implements PanacheRepository<Follower> {

    public boolean follows(User follower, User user){
        var params = Parameters
                .with("follower", follower)
                .and("user", user)
                .map();

        var query = find("follower =:follower and user =:user ", params);
        Optional<Follower> result = query.firstResultOptional();

        return result.isPresent();
    }

    public List<Follower> findByUser(Long userId){
        PanacheQuery<Follower> query = find("user.id", userId);
        return query.list();
    }
}
