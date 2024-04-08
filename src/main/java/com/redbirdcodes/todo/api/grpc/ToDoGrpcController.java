package com.redbirdcodes.todo.api.grpc;

import com.redbirdcodes.todo.core.dto.ToDoDTO;
import com.redbirdcodes.todo.core.exceptions.NoIdFoundException;
import com.redbirdcodes.todo.core.exceptions.NotFoundException;
import com.redbirdcodes.todo.core.services.ToDoService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@GrpcService
public class ToDoGrpcController extends ToDoApiGrpc.ToDoApiImplBase {

    @Autowired
    ToDoService toDoService;

    @Override
    public void getToDo(Id id, StreamObserver<ToDo> responseObserver) {
        try {
            responseObserver.onNext(checkToDo(id));
            responseObserver.onCompleted();
        } catch (NotFoundException e) {
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription(NotFoundException.MESSAGE).asRuntimeException());
        }
    }

    @Override
    public void listToDos(Empty request, StreamObserver<ToDo> responseObserver) {
        List<ToDoDTO> toDoDTOList = toDoService.getAllToDos();
        for (ToDoDTO toDoDTO : toDoDTOList) {
            responseObserver.onNext(convertFromDTO(toDoDTO));
        }
        responseObserver.onCompleted();
    }

    @Override
    public void saveToDo(ToDo request, StreamObserver<Empty> responseObserver) {
        toDoService.createToDo(convertToDTO(request));
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateToDo(ToDo request, StreamObserver<Empty> responseObserver) {
        try {
            toDoService.updateToDo(request.getId(), convertToDTO(request));
            responseObserver.onNext(Empty.newBuilder().build());
            responseObserver.onCompleted();
        } catch (NoIdFoundException e) {
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription(NoIdFoundException.MESSAGE).asRuntimeException());
        } catch (NotFoundException e) {
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription(NotFoundException.MESSAGE).asRuntimeException());
        }
    }

    @Override
    public void deleteToDo(Id request, StreamObserver<Empty> responseObserver) {
        try {
            toDoService.deleteToDo(request.getId());
            responseObserver.onNext(Empty.newBuilder().build());
            responseObserver.onCompleted();
        } catch (NoIdFoundException e) {
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription(NoIdFoundException.MESSAGE).asRuntimeException());
        } catch (NotFoundException e) {
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription(NotFoundException.MESSAGE).asRuntimeException());
        }

    }

    private ToDo checkToDo(Id id) throws NotFoundException {
        ToDoDTO toDoDTO = toDoService.getToDo(id.getId());
        return ToDo.newBuilder()
                .setId(toDoDTO.getId())
                .setTitle(toDoDTO.getTitle())
                .setDescription(toDoDTO.getDescription())
                .setStatus(toDoDTO.getStatus()).build();
    }

    private ToDo convertFromDTO(ToDoDTO toDoDTO) {
        return ToDo.newBuilder()
                .setId(toDoDTO.getId())
                .setTitle(toDoDTO.getTitle())
                .setDescription(toDoDTO.getDescription())
                .setStatus(toDoDTO.getStatus()).build();
    }

    private ToDoDTO convertToDTO(ToDo toDo) {
        ToDoDTO toDoDTO = new ToDoDTO();
        toDoDTO.setId(toDoDTO.getId());
        toDoDTO.setTitle(toDo.getTitle());
        toDoDTO.setDescription(toDo.getDescription());
        toDoDTO.setStatus(toDo.getStatus());
        return toDoDTO;
    }
}
