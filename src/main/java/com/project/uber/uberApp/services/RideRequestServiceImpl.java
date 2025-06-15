package com.project.uber.uberApp.services;

import com.project.uber.uberApp.enitities.RideRequest;
import com.project.uber.uberApp.exceptions.ResourceNotFoundException;
import com.project.uber.uberApp.repositories.RideRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestServiceImpl implements RideRequestService{
    //we are not using rideRequestRepository directly because :
    //1.Encapsulation
    //2.Loose Coupling

    private final RideRequestRepository rideRequestRepository;

    @Override
    public RideRequest findRideRequestById(Long rideRequestId) {
        return rideRequestRepository.findById(rideRequestId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("RideRequest not found with id: "+rideRequestId));
    }

    @Override
    public void update(RideRequest rideRequest) {
        //we don't want to create new rideRequest so if it exists then only we will update
        RideRequest toSave = rideRequestRepository.findById(rideRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("RideRequest not found with id: "+rideRequest.getId()));
        rideRequestRepository.save(rideRequest);
    }
}
