package com.onestop.demo.nativeimage.api;

import com.onestop.common.core.util.Res;
import org.springframework.web.bind.annotation.*;

/**
 * Native Image
 * @author Clark
 * @version 2022-2-22
 */
@RestController
public class NativeApi {

    /**
     * @return
     */
    @GetMapping("/")
    public Res get() {
        return Res.ok("Springboot3 Native Image!");
    }
}
