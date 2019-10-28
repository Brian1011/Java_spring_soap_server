package com.ics.soap.Endpoint;

import com.ics.soap.Repository.UniversityRepository;
import localhost._7991.universities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UniversityEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:7991/universities";
    private UniversityRepository universityRepository;

    @Autowired
    public UniversityEndpoint(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUniversityRequest")
    public GetUniversityResponse getUniversity(@RequestPayload GetUniversityRequest request) {
        GetUniversityResponse response = new GetUniversityResponse();
        response.setUniversity(universityRepository.getUniversityByName(request.getName()));
        System.out.println("University: "+response);
        return response;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUniversityByLocationRequest")
    public GetUniversityByLocationResponse getUniversityByLocationResponse(@RequestPayload GetUniversityByLocationRequest request){
        GetUniversityByLocationResponse response = new GetUniversityByLocationResponse();
        response.setUniversity(universityRepository.getUniversityByLocation(request.getLocation()));
        System.out.println("Location: "+response);
        return response;
    }

}
