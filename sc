#!/bin/sh

die ()
{
	printf '%s\n' "$1"
	exit 9
}


scbin='../shellcheck'
[ -f "$scbin" ] || die "missing file: $scbin"

# 1090 - Can't follow non-constant source. Use a directive to specify location.
# ,2016 - Expressions don't expand in single quotes, use double quotes for that.
# ,2034 - cert_depth appears unused. Verify use (or export if used externally).
# ,2039 - In POSIX sh, set option echo is undefined.
# ,2086 - Double quote to prevent globbing and word splitting.
# ,2153 - Possible misspelling: EASYTLS_MD_DIR may not be assigned, but EASYTLS_MKDIR is.
# ,2154 - foo is referenced but not assigned.
# ,2162 - read without -r will mangle backslashes.
# ,2236 - Use -n instead of ! -z.
# ,2244 - Prefer explicit -n to check non-empty string (or use =/-ne to check boolean/integer).
# ,2248 - Prefer double quoting even when variables don't contain special characters.
# ,2250 - Prefer putting braces around variable references even when not strictly required.
#


sc_e='-e 1090,2016,2039,2086,2153,2154,2162,2236,2244,2248,2250'
sc_i=''
sc_o='-o all'
sc_C='-Calways'

infiles="$@"
[ -z "$infiles" ] && infiles="easytls easytls*.sh"

outfile='../sc.out'

echo "Check: $infile"      > "$outfile"
echo "$(date)"            >> "$outfile"
echo "Options: $scopt"    >> "$outfile"

echo "$scbin" $sc_e $sc_o $sc_C $infiles
echo "shellcheckin' across the Universe.."

"$scbin" $sc_e $sc_o $sc_C $infiles >> "$outfile"

cat "$outfile"
rm  "$outfile"
