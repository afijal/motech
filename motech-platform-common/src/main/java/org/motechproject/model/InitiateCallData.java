/**
 * MOTECH PLATFORM OPENSOURCE LICENSE AGREEMENT
 *
 * Copyright (c) 2011 Grameen Foundation USA.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * 3. Neither the name of Grameen Foundation USA, nor its respective contributors
 * may be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY GRAMEEN FOUNDATION USA AND ITS CONTRIBUTORS
 * “AS IS” AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL GRAMEEN FOUNDATION USA OR ITS CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
 * IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY
 * OF SUCH DAMAGE.
 */
package org.motechproject.model;

import java.io.Serializable;

/**
 *
 * Date: 07/03/11
 *
 */
public class InitiateCallData implements Serializable {

    private static final long serialVersionUID = 1L;

    private long messageId;
    private String phone;
    private int timeOut; //how long IVR will wait for the channel to be answered before its considered to have failed (in ms)
    private String vxmlUrl;

    public InitiateCallData(long messageId, String phone, int timeOut, String vxmlUrl) {

         if (phone == null) {
            throw new IllegalArgumentException("phone can not be null");
        }

        if (vxmlUrl == null) {
            throw new IllegalArgumentException("vxmlUrl can not be null");
        }

        this.messageId = messageId;
        this.phone = phone;
        this.timeOut = timeOut;
        this.vxmlUrl = vxmlUrl;
    }

    public long getMessageId() {
        return messageId;
    }

    public String getPhone() {
        return phone;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public String getVxmlUrl() {
        return vxmlUrl;
    }
}
