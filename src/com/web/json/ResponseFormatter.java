package com.web.json;

import java.lang.StringBuilder;
import java.util.StringJoiner;

import static com.web.json.Formatter.newline;
import static com.web.json.Formatter.quote;
import static com.web.json.Formatter.space;
import static com.web.json.Formatter.jsonAttribute;
import static com.web.json.Formatter.getStringJoiner;
import static com.web.json.Formatter.jsonAttribute;

import com.web.http.Response;

public class ResponseFormatter implements Formatter<Response> {
    
    private Response res;

    public ResponseFormatter(Response res) {
        this.res = res;
    }

    @Override
    public String format() {
        StringBuilder output = new StringBuilder();
        output.append(jsonObj(res));
        return output.toString();
    }

    @Override
    public String jsonObj(Response res) {
        StringJoiner obj = getStringJoiner();
        obj.add(jsonAttribute("response code", res.getCode()));
        obj.add(jsonAttribute("message", res.getMessage()));
        return obj.toString();
    }
}