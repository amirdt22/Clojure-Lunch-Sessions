/**
 *   Copyright (c) Rich Hickey. All rights reserved.
 *   The use and distribution terms for this software are covered by the
 *   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 *   which can be found in the file epl-v10.html at the root of this distribution.
 *   By using this software in any fashion, you are agreeing to be bound by
 * 	 the terms of this license.
 *   You must not remove this notice, or any other, from this software.
 **/

/* rich Mar 29, 2006 10:39:05 AM */

package clojure.lang;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;


public final class Keyword implements IFn, Comparable, Named, Serializable {

private static ConcurrentHashMap<Symbol, SoftReference<Keyword>> table = new ConcurrentHashMap();
static final ReferenceQueue rq = new ReferenceQueue();
public final Symbol sym;
final int hash;

public static Keyword intern(Symbol sym){
	Util.clearCache(rq, table);
	Keyword k = new Keyword(sym);
	SoftReference<Keyword> existingRef = table.putIfAbsent(sym, new SoftReference<Keyword>(k,rq));
	if(existingRef == null)
		return k;
	Keyword existingk = existingRef.get();
	if(existingk != null)
		return existingk;
	//entry died in the interim, do over
	table.remove(sym, existingRef);
	return intern(sym);
}

public static Keyword intern(String ns, String name){
	return intern(Symbol.intern(ns, name));
}

public static Keyword intern(String nsname){
	return intern(Symbol.intern(nsname));
}

private Keyword(Symbol sym){
	this.sym = sym;
	hash = sym.hashCode() + 0x9e3779b9;
}

public static Keyword find(Symbol sym){
    SoftReference<Keyword> ref = table.get(sym);
    if (ref != null)
        return ref.get();
    else
        return null;
}

public static Keyword find(String ns, String name){
    return find(Symbol.intern(ns, name));
}

public static Keyword find(String nsname){
    return find(Symbol.intern(nsname));
}

public final int hashCode(){
	return hash;
}

public String toString(){
	return ":" + sym;
}

public Object throwArity(){
	throw new IllegalArgumentException("Wrong number of args passed to keyword: "
	                                   + toString());
}

public Object call() throws Exception{
	return throwArity();
}

public void run(){
	throw new UnsupportedOperationException();
}

public Object invoke() throws Exception{
	return throwArity();
}

public int compareTo(Object o){
	return sym.compareTo(((Keyword) o).sym);
}


public String getNamespace(){
	return sym.getNamespace();
}

public String getName(){
	return sym.getName();
}

private Object readResolve() throws ObjectStreamException{
	return intern(sym);
}

/**
 * Indexer implements IFn for attr access
 *
 * @param obj - must be IPersistentMap
 * @return the value at the key or nil if not found
 * @throws Exception
 */
final public Object invoke(Object obj) throws Exception{
	if(obj instanceof ILookup)
		return ((ILookup)obj).valAt(this);
	return RT.get(obj, this);
}

final public Object invoke(Object obj, Object notFound) throws Exception{
	if(obj instanceof ILookup)
		return ((ILookup)obj).valAt(this,notFound);
	return RT.get(obj, this, notFound);
}

public Object invoke(Object arg1, Object arg2, Object arg3) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7)
		throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13)
		throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14)
		throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                     Object arg15) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                     Object arg15, Object arg16) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                     Object arg15, Object arg16, Object arg17) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                     Object arg15, Object arg16, Object arg17, Object arg18) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                     Object arg15, Object arg16, Object arg17, Object arg18, Object arg19) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                     Object arg15, Object arg16, Object arg17, Object arg18, Object arg19, Object arg20)
		throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                     Object arg15, Object arg16, Object arg17, Object arg18, Object arg19, Object arg20,
                     Object... args)
		throws Exception{
	return throwArity();
}


public Object applyTo(ISeq arglist) throws Exception{
	return AFn.applyToHelper(this, arglist);
}


}
