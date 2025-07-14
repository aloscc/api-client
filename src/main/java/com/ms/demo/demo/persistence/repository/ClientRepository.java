package com.ms.demo.demo.persistence.repository;

import com.ms.demo.demo.persistence.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query("select avg(c.age) from Client c")
    Double averageAge();

    @Query("select stddev(c.age) from Client c")
    Double stddev();

    @Query("""
            select
            case
                when year(c.birthday) >= 1928 and year(c.birthday) < 1946 then 'Silent Generation'
                when year(c.birthday) >= 1946 and year(c.birthday) < 1965 then 'Baby boomer'
                when year(c.birthday) >= 1965 and year(c.birthday) < 1981 then 'Generation X'
                when year(c.birthday) >= 1981 and year(c.birthday) < 1997 then 'Millennial'
                when year(c.birthday) >= 1997 and year(c.birthday) < 2013 then 'Generation Z'
                when year(c.birthday) >= 2013 then 'Generation Alpha'
                else 'No Generation name'
            end
            from Client c
            where c.id =:id
            """)
    Optional<String> yearBirth(Long id);
}
