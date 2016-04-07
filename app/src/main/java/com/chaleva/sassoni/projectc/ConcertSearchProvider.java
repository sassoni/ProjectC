package com.chaleva.sassoni.projectc;

import com.chaleva.sassoni.projectc.Concert;

import java.util.List;

/**
 * Created by sassa on 4/5/16.
 */
public interface ConcertSearchProvider {

    List<Concert> getPastConcertsForSearchTerm(String searchTerm);
}
