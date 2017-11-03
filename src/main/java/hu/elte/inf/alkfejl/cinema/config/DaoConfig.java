package hu.elte.inf.alkfejl.cinema.config;


import hu.elte.inf.alkfejl.cinema.dao.*;
import hu.elte.inf.alkfejl.cinema.model.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.SessionFactoryUtils;

public class DaoConfig {

    @Autowired
    SessionFactory sessionFactory;

    @Bean
    MovieDao movieDao() {
        return new MovieDao(Movie.class, sessionFactory);
    }

    @Bean
    ScreeningDao screeningDao() {
        return new ScreeningDao(Screening.class, sessionFactory);
    }

    @Bean
    ActorDao actorDao() {
        return new ActorDao(Actor.class, sessionFactory);
    }

    @Bean
    CinemaRoomDao cinemaRoomDao() {
        return new CinemaRoomDao(CinemaRoom.class, sessionFactory);
    }

    @Bean
    UserDao userDao() {
        return new UserDao(User.class, sessionFactory);
    }

    @Bean
    ReservationDao ReservationDao() { return new ReservationDao(Reservation.class, sessionFactory); }
}
