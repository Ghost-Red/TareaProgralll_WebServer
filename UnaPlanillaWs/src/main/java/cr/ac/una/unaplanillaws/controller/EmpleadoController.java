/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.unaplanillaws.controller;

import cr.ac.una.unaplanillaws.model.EmpleadoDto;
import cr.ac.una.unaplanillaws.service.EmpleadoService;
import cr.ac.una.unaplanillaws.util.CodigoRespuesta;
import cr.ac.una.unaplanillaws.util.Respuesta;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author james
 */
@Path("/EmpleadoController")
@Tag(name = "Empleados", description = "Operaciones sobre empleados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmpleadoController {
    @EJB
    EmpleadoService empleadoService;
    
    @GET
    @Path("/empleado/{id}")
    
    public Response getEmpleado(@PathParam("id")Long id){
        try{
        Respuesta res= empleadoService.getEmpleado(id);
        if(!res.getEstado()){
            return Response.status(res.getCodigoRespuesta().getValue()).entity(res.getMensaje()).build();
        }
        return Response.ok(res.getResultado("Empleado")).build();
        }catch(Exception ex){
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obteniendo el empleado").build();
        }
        
    }
    
    @GET
    @Path("/empleados/{cedula}/{nombre}/{pApellido}")
    public Response getEmpleados(@PathParam("cedula") String cedula, @PathParam("nombre") String nombre, @PathParam("pApellido") String pApellido) {
        try {
            Respuesta res = empleadoService.getEmpleados(cedula, nombre, pApellido);
            if (!res.getEstado()) {
                return Response.status(res.getCodigoRespuesta().getValue()).entity(res.getMensaje()).build();
            }
            return Response.ok(new GenericEntity<List<EmpleadoDto>>((List<EmpleadoDto>) res.getResultado("Empleados")) {
            }).build();
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obteniendo los empleados").build();
        }
    }

    
    @POST
    @Path("/saveEmpleado")
    public Response guardarEmpleado(EmpleadoDto empleadoDto) {
        try {
            Respuesta res = empleadoService.guardarEmpleado(empleadoDto);
            if (!res.getEstado()) {
                return Response.status(res.getCodigoRespuesta().getValue()).entity(res.getMensaje()).build();
            }
            return Response.ok(res.getResultado("Empleado")).build();
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obteniendo el empleado").build();
        }
    }
    @GET
    @Path("/eliminarEmpleado/{id}")
    public Response eliminarEmpleado(@PathParam("id") Long id) {
        try {
            Respuesta res = empleadoService.eliminarEmpleado(id);
            if (!res.getEstado()) {
                return Response.status(res.getCodigoRespuesta().getValue()).entity(res.getMensaje()).build();
            }
            return Response.ok(res.getResultado("Empleado")).build();
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obteniendo el empleado").build();
        }
    }
    @GET
    @Path("/validarEmpleado/{usuario}/{clave}")
    public Response validarUsuario(@PathParam("usuario") String usuario, @PathParam("clave") String clave) {
        try {
            Respuesta res = empleadoService.validarUsuario(usuario, clave);
            if (!res.getEstado()) {
                return Response.status(res.getCodigoRespuesta().getValue()).entity(res.getMensaje()).build();
            }
            return Response.ok(res.getResultado("Empleado")).build();
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obteniendo el empleado").build();
        }
    }
    
    
    
    
}


    
    
    
    
