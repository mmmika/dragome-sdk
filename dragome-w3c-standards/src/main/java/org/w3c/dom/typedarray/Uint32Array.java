// Generated by esidl 0.4.0.

package org.w3c.dom.typedarray;

import org.w3c.dom.UnsignedLongArray;

public interface Uint32Array extends ArrayBufferView
{
    // Uint32Array
    public static final int BYTES_PER_ELEMENT = 4;
    public int getLength();
    public int get(int index);
    public void set(int index, int value);
    public void set(Uint32Array array);
    public void set(Uint32Array array, int offset);
    public void set(UnsignedLongArray array);
    public void set(UnsignedLongArray array, int offset);
    public Uint32Array subarray(int start, int end);
}
