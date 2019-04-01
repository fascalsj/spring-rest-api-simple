package com.belajar.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.belajar.restapi.entity.Hardware;

/**
 * @author fascal
 */
public interface HardwareRepository extends JpaRepository<Hardware, Long> {

}