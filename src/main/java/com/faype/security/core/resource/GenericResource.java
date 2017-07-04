package com.faype.security.core.resource;

import com.faype.security.core.domain.GenericDomain;
import com.faype.security.core.domain.QueryObject;
import com.faype.security.core.domain.SearchResponse;
import com.faype.security.core.global.ThreadScope;
import com.faype.security.core.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author wmfsystem
 * @param <F> WService
 * @param <E> WDomain
 * @param <D> Type Id
 */
@RestController
public abstract class GenericResource<F extends GenericService, E extends GenericDomain, D extends Serializable> {

    @Autowired
    public F service;

    /**
     * Overriding to get DTO correctly.
     */
    public Class domain;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<SearchResponse> findAll(QueryObject queryObject) {

        return ResponseEntity.status(HttpStatus.OK).body(service.findAll(queryObject));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<E> find(@PathVariable D id) {
        E response = (E) service.findOne(id);
        CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
        return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(response);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<E> save(@Valid @RequestBody E object) {

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(object.getId()).toUri();


        return ResponseEntity.created(uri).body((E) service.save(object));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<E> update(@RequestBody E object, @PathVariable("id") Serializable id, QueryObject queryObject) {
        object.setId(id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(object.getId()).toUri();
        return ResponseEntity.created(uri).body((E) service.update(object));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable D id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/dto", method = RequestMethod.GET)
    public Object getDto() throws Exception {
        if (this.domain == null) {
            return null;
        }
        return this.domain.newInstance();
    }

    @RequestMapping(value = "/thread-scope", method = RequestMethod.GET)
    public static List<ThreadLocal> getThreadLocal() {
        List<ThreadLocal> scope = new ArrayList();

        scope.add(ThreadScope.token);

        return scope;
    }

}
